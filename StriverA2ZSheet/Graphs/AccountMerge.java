class Solution {

    class DSU {

        // Stores parent of each node
        int[] parent;

        // Stores size of each component
        int[] size;

        DSU(int n) {

            // Create parent array of size n
            parent = new int[n];

            // Create size array of size n
            size = new int[n];

            // Initially every node is its own parent
            for(int i = 0; i < n; i++) {

                parent[i] = i;
                size[i] = 1;
            }

            /*
             Example for n = 3

             parent = [0,1,2]
             size   = [1,1,1]
            */
        }

        int findUPar(int node) {

            // If node itself is parent
            if(node == parent[node])
                return node;

            // Path Compression
            return parent[node] = findUPar(parent[node]);

            /*
             Example

             parent = [0,0,2]

             findUPar(1)

             1 -> 0

             returns 0

             parent remains

             [0,0,2]
            */
        }

        void unionBySize(int u, int v) {

            // Find ultimate parent of u
            int ulp_u = findUPar(u);

            // Find ultimate parent of v
            int ulp_v = findUPar(v);

            // Already connected
            if(ulp_u == ulp_v)
                return;

            // Attach smaller component to larger one
            if(size[ulp_u] < size[ulp_v]) {

                parent[ulp_u] = ulp_v;

                size[ulp_v] += size[ulp_u];
            }
            else {

                parent[ulp_v] = ulp_u;

                size[ulp_u] += size[ulp_v];
            }

            /*
             Example

             Component 1:
             Parent = 0, Size = 2

             Component 2:
             Parent = 3, Size = 1

             union(0,3)

             parent[3] = 0

             New size = 3
            */
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // Total accounts
        int n = accounts.size();

        /*
        Example

        0 -> John,a,b
        1 -> John,b,c
        2 -> Mary,x

        n = 3
        */

        // DSU object
        DSU ds = new DSU(n);

        // Email -> Account Index
        HashMap<String,Integer> mapMailNode =
                new HashMap<>();


        // -------------------------
        // STEP 1 : Build Email Map
        // STEP 2 : Union Accounts
        // -------------------------

        for(int i = 0; i < n; i++) {

            for(int j = 1; j < accounts.get(i).size(); j++) {

                String mail = accounts.get(i).get(j);

                /*
                 Example

                 Account 0

                 mail = a
                 mail = b
                */

                // First time email is seen
                if(!mapMailNode.containsKey(mail)) {

                    mapMailNode.put(mail, i);

                    /*
                    Example

                    a -> 0
                    b -> 0
                    x -> 2
                    */
                }

                // Email already exists
                else {

                    /*
                    Example

                    b already exists

                    b -> 0

                    Current account = 1
                    */

                    ds.unionBySize(
                            i,
                            mapMailNode.get(mail)
                    );

                    /*
                    union(1,0)

                    DSU

                    0
                    |
                    1

                    2
                    */
                }
            }
        }


        /*
         After loop

         HashMap

         a -> 0
         b -> 0
         c -> 1
         x -> 2
        */


        // -------------------------
        // STEP 3 : Create Groups
        // -------------------------

        ArrayList<String>[] mergedMail =
                new ArrayList[n];

        for(int i = 0; i < n; i++) {

            mergedMail[i] = new ArrayList<>();

        }

        /*
         mergedMail

         [ ]
         [ ]
         [ ]
        */


        // -------------------------
        // STEP 4 : Put emails under
        // their ultimate parent
        // -------------------------

        for(Map.Entry<String,Integer> entry
                : mapMailNode.entrySet()) {

            String mail = entry.getKey();

            // Find parent account
            int parent =
                    ds.findUPar(entry.getValue());

            // Store email under parent
            mergedMail[parent].add(mail);

            /*
            Example

            c -> 1

            findUPar(1)
            = 0

            mergedMail[0].add(c)

            Result

            mergedMail[0]
            [a,b,c]
            */
        }

        /*
         Final mergedMail

         mergedMail[0]
         [a,b,c]

         mergedMail[1]
         [ ]

         mergedMail[2]
         [x]
        */


        // -------------------------
        // STEP 5 : Create Answer
        // -------------------------

        List<List<String>> ans =
                new ArrayList<>();

        for(int i = 0; i < n; i++) {

            // No emails under this parent
            if(mergedMail[i].isEmpty())
                continue;

            // Sort emails lexicographically
            Collections.sort(mergedMail[i]);

            /*
            Before

            [c,a,b]

            After

            [a,b,c]
            */

            List<String> temp =
                    new ArrayList<>();

            // Add account name

            temp.add(accounts.get(i).get(0));

            /*
            temp

            [John]
            */

            // Add all emails

            for(String mail : mergedMail[i]) {

                temp.add(mail);
            }

            /*
            temp

            [John,a,b,c]
            */

            ans.add(temp);
        }


        // -------------------------
        // STEP 6 : Return Answer
        // -------------------------

        return ans;

        /*
         Output

         [
          [John,a,b,c],
          [Mary,x]
         ]
        */
    }
}
