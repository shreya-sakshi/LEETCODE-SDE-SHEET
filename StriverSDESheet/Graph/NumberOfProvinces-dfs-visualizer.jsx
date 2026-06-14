import { useState, useEffect, useRef } from "react";

// ─── DATA ────────────────────────────────────────────────────────────────────

const CODE_LINES = [
  { id: 0,  text: "static int numProvinces(adj, V=4) {",                      indent: 0 },
  { id: 1,  text: "  adjLs = new ArrayList<>();  // 4 empty lists",           indent: 1 },
  { id: 2,  text: "  for i=0→3: adjLs.add(new ArrayList<>())",               indent: 1 },
  { id: 3,  text: "  // Convert matrix → adjacency list",                     indent: 1, comment: true },
  { id: 4,  text: "  for i=0→3, j=0→3:",                                     indent: 1 },
  { id: 5,  text: "    if adj[i][j]==1 && i!=j → add edges",                 indent: 2 },
  { id: 6,  text: "  int vis[] = new int[4]  // [0,0,0,0]",                  indent: 1 },
  { id: 7,  text: "  int cnt = 0",                                             indent: 1 },
  { id: 8,  text: "  for i=0: vis[0]==0 → cnt++; dfs(0)",                    indent: 1 },
  { id: 9,  text: "    dfs(0): vis[0]=1",                                      indent: 2 },
  { id: 10, text: "    dfs(0) neighbor→1: vis[1]==0 → dfs(1)",               indent: 2 },
  { id: 11, text: "      dfs(1): vis[1]=1",                                    indent: 3 },
  { id: 12, text: "      dfs(1) neighbor→0: vis[0]==1 → SKIP",               indent: 3 },
  { id: 13, text: "      dfs(1) neighbor→2: vis[2]==0 → dfs(2)",             indent: 3 },
  { id: 14, text: "        dfs(2): vis[2]=1",                                  indent: 4 },
  { id: 15, text: "        dfs(2) neighbor→1: vis[1]==1 → SKIP",             indent: 4 },
  { id: 16, text: "      ← dfs(2) returns",                                   indent: 3 },
  { id: 17, text: "    ← dfs(1) returns",                                     indent: 2 },
  { id: 18, text: "  ← dfs(0) returns  // Province 1: {0,1,2} done",        indent: 1 },
  { id: 19, text: "  for i=1: vis[1]==1 → SKIP",                             indent: 1 },
  { id: 20, text: "  for i=2: vis[2]==1 → SKIP",                             indent: 1 },
  { id: 21, text: "  for i=3: vis[3]==0 → cnt++; dfs(3)",                    indent: 1 },
  { id: 22, text: "    dfs(3): vis[3]=1  // no neighbors",                    indent: 2 },
  { id: 23, text: "  ← dfs(3) returns  // Province 2: {3} done",            indent: 1 },
  { id: 24, text: "  return cnt  // ✅ Answer = 2",                           indent: 1 },
  { id: 25, text: "}",                                                          indent: 0 },
];

const STEPS = [
  {
    line: 0,
    title: "Function Called",
    desc: "numProvinces is called with V=4 nodes and a 4×4 adjacency matrix.",
    vis: [0,0,0,0], cnt: 0, adjLs: [[],[],[],[]],
    activeNode: null, visitedNodes: [], graphEdges: [], provinces: [],
    output: "numProvinces(adj, V=4) called",
    outputType: "info",
    callStack: ["numProvinces"],
    matrixHighlight: null,
  },
  {
    line: 1,
    title: "Create adjLs",
    desc: "Build an empty adjacency list: 4 slots, one per node.",
    vis: [0,0,0,0], cnt: 0, adjLs: [[],[],[],[]],
    activeNode: null, visitedNodes: [], graphEdges: [], provinces: [],
    output: "adjLs = [[], [], [], []]",
    outputType: "info",
    callStack: ["numProvinces"],
    matrixHighlight: null,
  },
  {
    line: 2,
    title: "Init adjLs slots",
    desc: "Loop i=0..3, push empty ArrayList into each slot.",
    vis: [0,0,0,0], cnt: 0, adjLs: [[],[],[],[]],
    activeNode: null, visitedNodes: [], graphEdges: [], provinces: [],
    output: "adjLs[0]=[] adjLs[1]=[] adjLs[2]=[] adjLs[3]=[]",
    outputType: "info",
    callStack: ["numProvinces"],
    matrixHighlight: null,
  },
  {
    line: 4,
    title: "Matrix → List (start)",
    desc: "Outer loop i=0..3, inner loop j=0..3. Check adj[i][j]==1 && i≠j.",
    vis: [0,0,0,0], cnt: 0, adjLs: [[],[],[],[]],
    activeNode: null, visitedNodes: [], graphEdges: [], provinces: [],
    output: "Scanning matrix for edges...",
    outputType: "info",
    callStack: ["numProvinces"],
    matrixHighlight: null,
  },
  {
    line: 5,
    title: "Edge 0↔1 Found",
    desc: "adj[0][1]==1 and 0≠1 → adjLs[0].add(1), adjLs[1].add(0)",
    vis: [0,0,0,0], cnt: 0, adjLs: [[1],[0],[],[]], // partial
    activeNode: null, visitedNodes: [], graphEdges: [{a:0,b:1}], provinces: [],
    output: "adj[0][1]=1 → edge 0↔1 added\nadjLs[0]=[1], adjLs[1]=[0]",
    outputType: "edge",
    callStack: ["numProvinces"],
    matrixHighlight: [0,1],
  },
  {
    line: 5,
    title: "Edge 1↔2 Found",
    desc: "adj[1][2]==1 and 1≠2 → adjLs[1].add(2), adjLs[2].add(1)",
    vis: [0,0,0,0], cnt: 0, adjLs: [[1],[0,2],[1],[]],
    activeNode: null, visitedNodes: [], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "adj[1][2]=1 → edge 1↔2 added\nadjLs[1]=[0,2], adjLs[2]=[1]",
    outputType: "edge",
    callStack: ["numProvinces"],
    matrixHighlight: [1,2],
  },
  {
    line: 6,
    title: "vis[] Initialized",
    desc: "int vis[] = new int[4] → all zeros. No node visited yet.",
    vis: [0,0,0,0], cnt: 0, adjLs: [[1],[0,2],[1],[]],
    activeNode: null, visitedNodes: [], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "vis = [0, 0, 0, 0]",
    outputType: "info",
    callStack: ["numProvinces"],
    matrixHighlight: null,
  },
  {
    line: 7,
    title: "cnt = 0",
    desc: "Province counter starts at 0.",
    vis: [0,0,0,0], cnt: 0, adjLs: [[1],[0,2],[1],[]],
    activeNode: null, visitedNodes: [], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "cnt = 0",
    outputType: "info",
    callStack: ["numProvinces"],
    matrixHighlight: null,
  },
  {
    line: 8,
    title: "i=0: vis[0]==0 → New Province!",
    desc: "Node 0 is unvisited. cnt becomes 1. Call dfs(0) to explore its component.",
    vis: [0,0,0,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: 0, visitedNodes: [], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "vis[0]==0 → cnt++ → cnt=1\n→ calling dfs(0)",
    outputType: "province",
    callStack: ["numProvinces", "dfs(0)"],
    matrixHighlight: null,
  },
  {
    line: 9,
    title: "dfs(0): Mark node 0 visited",
    desc: "vis[0] = 1. Now loop through neighbors of 0: adjLs[0] = [1]",
    vis: [1,0,0,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: 0, visitedNodes: [0], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "vis[0] = 1\nNeighbors of 0: [1]",
    outputType: "visit",
    callStack: ["numProvinces", "dfs(0)"],
    matrixHighlight: null,
  },
  {
    line: 10,
    title: "dfs(0) → neighbor 1: unvisited!",
    desc: "vis[1]==0, so recurse: call dfs(1)",
    vis: [1,0,0,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: 1, visitedNodes: [0], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "neighbor=1, vis[1]==0 → dfs(1)",
    outputType: "recurse",
    callStack: ["numProvinces", "dfs(0)", "dfs(1)"],
    matrixHighlight: null,
  },
  {
    line: 11,
    title: "dfs(1): Mark node 1 visited",
    desc: "vis[1] = 1. Neighbors of 1: adjLs[1] = [0, 2]",
    vis: [1,1,0,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: 1, visitedNodes: [0,1], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "vis[1] = 1\nNeighbors of 1: [0, 2]",
    outputType: "visit",
    callStack: ["numProvinces", "dfs(0)", "dfs(1)"],
    matrixHighlight: null,
  },
  {
    line: 12,
    title: "dfs(1) → neighbor 0: SKIP",
    desc: "vis[0]==1 already. Skip node 0.",
    vis: [1,1,0,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: 1, visitedNodes: [0,1], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "neighbor=0, vis[0]==1 → SKIP",
    outputType: "skip",
    callStack: ["numProvinces", "dfs(0)", "dfs(1)"],
    matrixHighlight: null,
  },
  {
    line: 13,
    title: "dfs(1) → neighbor 2: unvisited!",
    desc: "vis[2]==0, so recurse: call dfs(2)",
    vis: [1,1,0,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: 2, visitedNodes: [0,1], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "neighbor=2, vis[2]==0 → dfs(2)",
    outputType: "recurse",
    callStack: ["numProvinces", "dfs(0)", "dfs(1)", "dfs(2)"],
    matrixHighlight: null,
  },
  {
    line: 14,
    title: "dfs(2): Mark node 2 visited",
    desc: "vis[2] = 1. Neighbors of 2: adjLs[2] = [1]",
    vis: [1,1,1,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: 2, visitedNodes: [0,1,2], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "vis[2] = 1\nNeighbors of 2: [1]",
    outputType: "visit",
    callStack: ["numProvinces", "dfs(0)", "dfs(1)", "dfs(2)"],
    matrixHighlight: null,
  },
  {
    line: 15,
    title: "dfs(2) → neighbor 1: SKIP",
    desc: "vis[1]==1 already. Skip. No more neighbors. dfs(2) ends.",
    vis: [1,1,1,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: 2, visitedNodes: [0,1,2], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "neighbor=1, vis[1]==1 → SKIP\ndfs(2) has no more neighbors",
    outputType: "skip",
    callStack: ["numProvinces", "dfs(0)", "dfs(1)", "dfs(2)"],
    matrixHighlight: null,
  },
  {
    line: 16,
    title: "← dfs(2) returns",
    desc: "Stack unwinds back to dfs(1).",
    vis: [1,1,1,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: 1, visitedNodes: [0,1,2], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "← dfs(2) returns to dfs(1)",
    outputType: "return",
    callStack: ["numProvinces", "dfs(0)", "dfs(1)"],
    matrixHighlight: null,
  },
  {
    line: 17,
    title: "← dfs(1) returns",
    desc: "All neighbors of 1 exhausted. Stack unwinds back to dfs(0).",
    vis: [1,1,1,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: 0, visitedNodes: [0,1,2], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [],
    output: "← dfs(1) returns to dfs(0)",
    outputType: "return",
    callStack: ["numProvinces", "dfs(0)"],
    matrixHighlight: null,
  },
  {
    line: 18,
    title: "← dfs(0) returns → Province 1 complete!",
    desc: "Entire connected component {0, 1, 2} explored. Province 1 found.",
    vis: [1,1,1,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: null, visitedNodes: [0,1,2], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [[0,1,2]],
    output: "← dfs(0) returns\n✓ Province 1 = {0, 1, 2}",
    outputType: "province",
    callStack: ["numProvinces"],
    matrixHighlight: null,
  },
  {
    line: 19,
    title: "i=1: vis[1]==1 → SKIP",
    desc: "Node 1 already visited. Continue loop.",
    vis: [1,1,1,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: null, visitedNodes: [0,1,2], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [[0,1,2]],
    output: "i=1: vis[1]==1 → SKIP",
    outputType: "skip",
    callStack: ["numProvinces"],
    matrixHighlight: null,
  },
  {
    line: 20,
    title: "i=2: vis[2]==1 → SKIP",
    desc: "Node 2 already visited. Continue loop.",
    vis: [1,1,1,0], cnt: 1, adjLs: [[1],[0,2],[1],[]],
    activeNode: null, visitedNodes: [0,1,2], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [[0,1,2]],
    output: "i=2: vis[2]==1 → SKIP",
    outputType: "skip",
    callStack: ["numProvinces"],
    matrixHighlight: null,
  },
  {
    line: 21,
    title: "i=3: vis[3]==0 → New Province!",
    desc: "Node 3 is unvisited! cnt becomes 2. Call dfs(3).",
    vis: [1,1,1,0], cnt: 2, adjLs: [[1],[0,2],[1],[]],
    activeNode: 3, visitedNodes: [0,1,2], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [[0,1,2]],
    output: "vis[3]==0 → cnt++ → cnt=2\n→ calling dfs(3)",
    outputType: "province",
    callStack: ["numProvinces", "dfs(3)"],
    matrixHighlight: null,
  },
  {
    line: 22,
    title: "dfs(3): Mark node 3 visited",
    desc: "vis[3] = 1. adjLs[3] = [] — no neighbors. dfs(3) ends immediately.",
    vis: [1,1,1,1], cnt: 2, adjLs: [[1],[0,2],[1],[]],
    activeNode: 3, visitedNodes: [0,1,2,3], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [[0,1,2]],
    output: "vis[3] = 1\nNeighbors of 3: [] → done",
    outputType: "visit",
    callStack: ["numProvinces", "dfs(3)"],
    matrixHighlight: null,
  },
  {
    line: 23,
    title: "← dfs(3) returns → Province 2 complete!",
    desc: "Node 3 is isolated (no neighbors). Province 2 = {3}.",
    vis: [1,1,1,1], cnt: 2, adjLs: [[1],[0,2],[1],[]],
    activeNode: null, visitedNodes: [0,1,2,3], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [[0,1,2],[3]],
    output: "← dfs(3) returns\n✓ Province 2 = {3}",
    outputType: "province",
    callStack: ["numProvinces"],
    matrixHighlight: null,
  },
  {
    line: 24,
    title: "return cnt = 2 ✅",
    desc: "All nodes visited. Two distinct connected components found. Final answer: 2.",
    vis: [1,1,1,1], cnt: 2, adjLs: [[1],[0,2],[1],[]],
    activeNode: null, visitedNodes: [0,1,2,3], graphEdges: [{a:0,b:1},{a:1,b:2}], provinces: [[0,1,2],[3]],
    output: "return 2\n\n✅ FINAL OUTPUT: 2 Provinces",
    outputType: "final",
    callStack: [],
    matrixHighlight: null,
  },
];

// ─── CONSTANTS ────────────────────────────────────────────────────────────────

const NODE_POS = [
  { x: 80,  y: 70  },
  { x: 190, y: 70  },
  { x: 190, y: 160 },
  { x: 310, y: 115 },
];

const PROVINCE_COLORS = ["#34d399", "#60a5fa", "#f472b6", "#fbbf24"];

const OUTPUT_STYLES = {
  info:    { bg: "#0f2744", border: "#3b82f6", icon: "ℹ", color: "#93c5fd" },
  edge:    { bg: "#0c2a1a", border: "#22c55e", icon: "⟷", color: "#86efac" },
  visit:   { bg: "#1a1a2e", border: "#818cf8", icon: "●", color: "#a5b4fc" },
  recurse: { bg: "#2d1b4e", border: "#a855f7", icon: "↳", color: "#d8b4fe" },
  skip:    { bg: "#2d1010", border: "#ef4444", icon: "✗", color: "#fca5a5" },
  return:  { bg: "#1e1b2e", border: "#6366f1", icon: "↩", color: "#c7d2fe" },
  province:{ bg: "#0a2e1a", border: "#10b981", icon: "★", color: "#6ee7b7" },
  final:   { bg: "#1a2e0a", border: "#84cc16", icon: "✅", color: "#bef264" },
};

const MATRIX = [
  [1,1,0,0],
  [1,1,1,0],
  [0,1,1,0],
  [0,0,0,1],
];

// ─── SUBCOMPONENTS ────────────────────────────────────────────────────────────

function GraphPanel({ edges, visitedNodes, activeNode, provinces }) {
  const provinceOf = (n) => {
    for (let i = 0; i < provinces.length; i++) if (provinces[i].includes(n)) return i;
    return -1;
  };

  return (
    <div style={{ background: "#0b1120", borderRadius: 12, padding: 12, border: "1px solid #1e293b" }}>
      <div style={{ fontSize: 10, color: "#475569", marginBottom: 8, textTransform: "uppercase", letterSpacing: "0.12em" }}>Graph</div>
      <svg width="100%" viewBox="0 0 390 230" style={{ display: "block" }}>
        {/* edges */}
        {edges.map((e, i) => {
          const pi = provinceOf(e.a);
          const color = pi >= 0 ? PROVINCE_COLORS[pi] : "#334155";
          return (
            <line key={i}
              x1={NODE_POS[e.a].x} y1={NODE_POS[e.a].y}
              x2={NODE_POS[e.b].x} y2={NODE_POS[e.b].y}
              stroke={color} strokeWidth={pi >= 0 ? 3 : 2} strokeOpacity={0.7}
            />
          );
        })}
        {/* nodes */}
        {NODE_POS.map((pos, idx) => {
          const pi = provinceOf(idx);
          const isActive = activeNode === idx;
          const isVisited = visitedNodes.includes(idx);
          const fill = isActive ? "#f59e0b" : pi >= 0 ? PROVINCE_COLORS[pi] + "33" : isVisited ? "#312e81" : "#1e293b";
          const stroke = isActive ? "#fbbf24" : pi >= 0 ? PROVINCE_COLORS[pi] : isVisited ? "#818cf8" : "#475569";
          const textColor = isActive ? "#fff" : pi >= 0 ? PROVINCE_COLORS[pi] : isVisited ? "#a5b4fc" : "#64748b";
          return (
            <g key={idx}>
              {isActive && (
                <circle cx={pos.x} cy={pos.y} r={36} fill="#f59e0b" fillOpacity={0.12} />
              )}
              <circle cx={pos.x} cy={pos.y} r={26} fill={fill} stroke={stroke} strokeWidth={isActive ? 3 : 2} />
              <text x={pos.x} y={pos.y + 5} textAnchor="middle" fill={textColor} fontSize={14} fontWeight="700">{idx}</text>
              {isActive && (
                <text x={pos.x} y={pos.y - 36} textAnchor="middle" fill="#f59e0b" fontSize={10} fontWeight="600">ACTIVE</text>
              )}
              {pi >= 0 && !isActive && (
                <text x={pos.x} y={pos.y - 36} textAnchor="middle" fill={PROVINCE_COLORS[pi]} fontSize={10}>P{pi+1}</text>
              )}
            </g>
          );
        })}
        {/* legend */}
        {[["#f59e0b","Active"],["#818cf8","Visited"],["#34d399","Province 1"],["#60a5fa","Province 2"]].map(([c,l],i) => (
          <g key={i} transform={`translate(${i < 2 ? i*90 : (i-2)*110}, 205)`}>
            <circle cx={7} cy={7} r={6} fill={c} fillOpacity={0.25} stroke={c} strokeWidth={1.5} />
            <text x={17} y={12} fill="#64748b" fontSize={10}>{l}</text>
          </g>
        ))}
      </svg>
    </div>
  );
}

function MatrixPanel({ highlight }) {
  return (
    <div style={{ background: "#0b1120", borderRadius: 12, padding: 12, border: "1px solid #1e293b" }}>
      <div style={{ fontSize: 10, color: "#475569", marginBottom: 8, textTransform: "uppercase", letterSpacing: "0.12em" }}>Adjacency Matrix</div>
      <table style={{ borderCollapse: "separate", borderSpacing: 3, fontFamily: "monospace", fontSize: 13 }}>
        <thead>
          <tr>
            <td style={{ padding: "2px 6px", color: "#334155" }}></td>
            {[0,1,2,3].map(j => <th key={j} style={{ padding: "2px 10px", color: "#64748b", fontWeight: 600 }}>{j}</th>)}
          </tr>
        </thead>
        <tbody>
          {MATRIX.map((row, i) => (
            <tr key={i}>
              <td style={{ padding: "2px 6px", color: "#64748b", fontWeight: 600 }}>{i}</td>
              {row.map((v, j) => {
                const isEdge = v === 1 && i !== j;
                const isHighlit = highlight && highlight[0] === i && highlight[1] === j;
                return (
                  <td key={j} style={{
                    padding: "5px 10px", borderRadius: 6, textAlign: "center",
                    background: isHighlit ? "#7c3aed" : isEdge ? "#1e3a5f" : "#0f172a",
                    color: isHighlit ? "#fff" : isEdge ? "#60a5fa" : "#334155",
                    fontWeight: isEdge ? "700" : "400",
                    border: isHighlit ? "1.5px solid #a78bfa" : "1.5px solid transparent",
                    transition: "all 0.3s",
                  }}>{v}</td>
                );
              })}
            </tr>
          ))}
        </tbody>
      </table>
      <div style={{ color: "#334155", fontSize: 10, marginTop: 6 }}>Blue = edge | Purple = current check</div>
    </div>
  );
}

function VisPanel({ vis, cnt }) {
  return (
    <div style={{ background: "#0b1120", borderRadius: 12, padding: 12, border: "1px solid #1e293b" }}>
      <div style={{ fontSize: 10, color: "#475569", marginBottom: 10, textTransform: "uppercase", letterSpacing: "0.12em" }}>Variables</div>
      <div style={{ marginBottom: 10 }}>
        <div style={{ fontSize: 10, color: "#475569", marginBottom: 4 }}>vis[]</div>
        <div style={{ display: "flex", gap: 6 }}>
          {vis.map((v, i) => (
            <div key={i} style={{ textAlign: "center" }}>
              <div style={{
                width: 38, height: 38, borderRadius: 8, display: "flex", alignItems: "center", justifyContent: "center",
                background: v === 1 ? "#312e81" : "#0f172a",
                border: v === 1 ? "1.5px solid #818cf8" : "1.5px solid #1e293b",
                color: v === 1 ? "#a5b4fc" : "#334155",
                fontFamily: "monospace", fontWeight: "700", fontSize: 16,
                transition: "all 0.4s",
              }}>{v}</div>
              <div style={{ fontSize: 9, color: "#334155", marginTop: 3 }}>[{i}]</div>
            </div>
          ))}
        </div>
      </div>
      <div style={{ display: "flex", alignItems: "center", gap: 10 }}>
        <div style={{ fontSize: 10, color: "#475569" }}>cnt =</div>
        <div style={{
          fontSize: 28, fontWeight: "800", fontFamily: "monospace",
          color: cnt > 0 ? "#34d399" : "#334155",
          transition: "all 0.3s",
        }}>{cnt}</div>
        <div style={{ fontSize: 10, color: "#334155" }}>provinces</div>
      </div>
    </div>
  );
}

function AdjLsPanel({ adjLs }) {
  return (
    <div style={{ background: "#0b1120", borderRadius: 12, padding: 12, border: "1px solid #1e293b" }}>
      <div style={{ fontSize: 10, color: "#475569", marginBottom: 8, textTransform: "uppercase", letterSpacing: "0.12em" }}>adjLs (Adjacency List)</div>
      {adjLs.map((neighbors, i) => (
        <div key={i} style={{ display: "flex", alignItems: "center", gap: 6, marginBottom: 6 }}>
          <div style={{
            width: 22, height: 22, borderRadius: 6, background: "#0f172a", border: "1px solid #334155",
            display: "flex", alignItems: "center", justifyContent: "center",
            fontSize: 11, color: "#64748b", fontFamily: "monospace", fontWeight: "700"
          }}>{i}</div>
          <div style={{ fontSize: 11, color: "#334155" }}>→</div>
          <div style={{ display: "flex", gap: 4 }}>
            {neighbors.length === 0
              ? <span style={{ fontSize: 11, color: "#1e293b", fontFamily: "monospace" }}>[ ]</span>
              : neighbors.map((n, j) => (
                  <div key={j} style={{
                    padding: "2px 8px", borderRadius: 5, background: "#1e293b",
                    border: "1px solid #334155", fontSize: 11, color: "#60a5fa",
                    fontFamily: "monospace", fontWeight: "600"
                  }}>{n}</div>
                ))
            }
          </div>
        </div>
      ))}
    </div>
  );
}

function CallStack({ stack }) {
  return (
    <div style={{ background: "#0b1120", borderRadius: 12, padding: 12, border: "1px solid #1e293b" }}>
      <div style={{ fontSize: 10, color: "#475569", marginBottom: 8, textTransform: "uppercase", letterSpacing: "0.12em" }}>Call Stack</div>
      {stack.length === 0
        ? <div style={{ fontSize: 11, color: "#1e293b", fontFamily: "monospace" }}>empty</div>
        : [...stack].reverse().map((fn, i) => (
          <div key={i} style={{
            padding: "5px 10px", borderRadius: 6, marginBottom: 4, fontFamily: "monospace", fontSize: 12,
            background: i === 0 ? "#1e1b4b" : "#0f172a",
            border: i === 0 ? "1px solid #6366f1" : "1px solid #1e293b",
            color: i === 0 ? "#a5b4fc" : "#475569",
          }}>
            {i === 0 && <span style={{ color: "#6366f1", marginRight: 6 }}>▶</span>}{fn}
          </div>
        ))
      }
    </div>
  );
}

function OutputPanel({ output, outputType }) {
  const style = OUTPUT_STYLES[outputType] || OUTPUT_STYLES.info;
  return (
    <div style={{
      background: style.bg, border: `1.5px solid ${style.border}`, borderRadius: 12, padding: 14,
      transition: "all 0.3s",
    }}>
      <div style={{ fontSize: 10, color: style.border, marginBottom: 6, textTransform: "uppercase", letterSpacing: "0.12em" }}>
        {style.icon} Output / Result
      </div>
      <pre style={{
        margin: 0, fontFamily: "'SF Mono', 'Fira Code', monospace", fontSize: 13,
        color: style.color, whiteSpace: "pre-wrap", lineHeight: 1.6,
      }}>{output}</pre>
    </div>
  );
}

function ProvincePanel({ provinces }) {
  if (provinces.length === 0) return null;
  return (
    <div style={{ display: "flex", gap: 8, flexWrap: "wrap" }}>
      {provinces.map((p, i) => (
        <div key={i} style={{
          padding: "6px 14px", borderRadius: 20,
          background: PROVINCE_COLORS[i] + "22",
          border: `1.5px solid ${PROVINCE_COLORS[i]}`,
          color: PROVINCE_COLORS[i], fontFamily: "monospace", fontSize: 13, fontWeight: "700",
        }}>
          Province {i+1}: {"{" + p.join(", ") + "}"}
        </div>
      ))}
    </div>
  );
}

// ─── MAIN ─────────────────────────────────────────────────────────────────────

export default function App() {
  const [step, setStep] = useState(0);
  const [playing, setPlaying] = useState(false);
  const codeRef = useRef(null);
  const s = STEPS[step];

  useEffect(() => {
    if (!playing) return;
    if (step >= STEPS.length - 1) { setPlaying(false); return; }
    const t = setTimeout(() => setStep(x => x + 1), 2000);
    return () => clearTimeout(t);
  }, [playing, step]);

  // scroll active code line into view
  useEffect(() => {
    if (codeRef.current) {
      const el = codeRef.current.querySelector(`[data-line="${s.line}"]`);
      if (el) el.scrollIntoView({ block: "nearest", behavior: "smooth" });
    }
  }, [step]);

  return (
    <div style={{
      minHeight: "100vh", background: "#020617", color: "#f1f5f9",
      fontFamily: "'Inter', system-ui, sans-serif",
      padding: "16px", boxSizing: "border-box",
    }}>
      {/* Header */}
      <div style={{ textAlign: "center", marginBottom: 16 }}>
        <div style={{ fontSize: 10, color: "#334155", letterSpacing: "0.2em", textTransform: "uppercase" }}>DFS Step-by-Step Dry Run</div>
        <h1 style={{ fontSize: 18, fontWeight: 800, margin: "4px 0", color: "#f8fafc" }}>numProvinces — Line by Line</h1>
        <div style={{ fontSize: 12, color: "#475569" }}>V=4 nodes · Edges: 0↔1, 1↔2 · Expected answer: 2</div>
      </div>

      {/* Progress bar */}
      <div style={{ background: "#0f172a", height: 4, borderRadius: 4, marginBottom: 16, overflow: "hidden" }}>
        <div style={{
          height: "100%", borderRadius: 4,
          background: "linear-gradient(90deg, #6366f1, #34d399)",
          width: `${((step + 1) / STEPS.length) * 100}%`,
          transition: "width 0.4s ease",
        }} />
      </div>

      {/* Step label */}
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: 12 }}>
        <div style={{ fontSize: 13, color: "#64748b" }}>Step {step + 1} / {STEPS.length}</div>
        <div style={{
          fontSize: 13, fontWeight: "700", color: "#f59e0b",
          background: "#1c1500", border: "1px solid #f59e0b44",
          padding: "3px 12px", borderRadius: 20,
        }}>{s.title}</div>
      </div>

      {/* Two-column layout */}
      <div style={{ display: "flex", gap: 12, alignItems: "flex-start", flexWrap: "wrap" }}>

        {/* LEFT: Code panel */}
        <div style={{
          flex: "0 0 340px", minWidth: 280,
          background: "#0b1120", borderRadius: 12, border: "1px solid #1e293b",
          overflow: "hidden",
        }}>
          <div style={{ padding: "8px 14px", background: "#0f172a", borderBottom: "1px solid #1e293b", display: "flex", gap: 6 }}>
            {["#ef4444","#f59e0b","#22c55e"].map(c => <div key={c} style={{ width: 10, height: 10, borderRadius: "50%", background: c }} />)}
            <span style={{ fontSize: 11, color: "#334155", marginLeft: 8, fontFamily: "monospace" }}>Solution.java</span>
          </div>
          <div ref={codeRef} style={{ padding: "10px 0", maxHeight: 420, overflowY: "auto" }}>
            {CODE_LINES.map((cl) => {
              const isActive = cl.id === s.line;
              return (
                <div key={cl.id} data-line={cl.id} style={{
                  padding: "3px 14px",
                  background: isActive ? "#1e1b4b" : "transparent",
                  borderLeft: isActive ? "3px solid #6366f1" : "3px solid transparent",
                  transition: "background 0.3s",
                  display: "flex", alignItems: "center", gap: 10,
                }}>
                  <span style={{ fontSize: 10, color: "#1e293b", width: 18, textAlign: "right", flexShrink: 0, fontFamily: "monospace" }}>{cl.id + 1}</span>
                  <span style={{
                    fontSize: 12, fontFamily: "monospace", whiteSpace: "nowrap",
                    paddingLeft: cl.indent * 14,
                    color: cl.comment ? "#475569" : isActive ? "#c7d2fe" : "#64748b",
                    fontStyle: cl.comment ? "italic" : "normal",
                    fontWeight: isActive ? "600" : "400",
                  }}>{cl.text}</span>
                  {isActive && <span style={{ fontSize: 10, color: "#6366f1", flexShrink: 0 }}>◀</span>}
                </div>
              );
            })}
          </div>
        </div>

        {/* RIGHT: all panels */}
        <div style={{ flex: 1, minWidth: 280, display: "flex", flexDirection: "column", gap: 10 }}>
          <OutputPanel output={s.output} outputType={s.outputType} />
          <div style={{ fontSize: 11, color: "#475569", padding: "4px 0" }}>{s.desc}</div>
          <GraphPanel edges={s.graphEdges} visitedNodes={s.visitedNodes} activeNode={s.activeNode} provinces={s.provinces} />
          <div style={{ display: "flex", gap: 10, flexWrap: "wrap" }}>
            <div style={{ flex: 1, minWidth: 160 }}><VisPanel vis={s.vis} cnt={s.cnt} /></div>
            <div style={{ flex: 1, minWidth: 160 }}><CallStack stack={s.callStack} /></div>
          </div>
          <AdjLsPanel adjLs={s.adjLs} />
          <MatrixPanel highlight={s.matrixHighlight} />
          {s.provinces.length > 0 && <ProvincePanel provinces={s.provinces} />}
        </div>
      </div>

      {/* Controls */}
      <div style={{ display: "flex", gap: 10, justifyContent: "center", marginTop: 20, flexWrap: "wrap" }}>
        <button onClick={() => { setPlaying(false); setStep(0); }}
          style={{ padding: "9px 18px", background: "#0f172a", color: "#64748b", border: "1px solid #1e293b", borderRadius: 8, cursor: "pointer", fontSize: 13 }}>
          ⏮ Reset
        </button>
        <button onClick={() => { setPlaying(false); setStep(s => Math.max(0, s - 1)); }} disabled={step === 0}
          style={{ padding: "9px 18px", background: "#0f172a", color: step === 0 ? "#1e293b" : "#94a3b8", border: "1px solid #1e293b", borderRadius: 8, cursor: "pointer", fontSize: 13 }}>
          ← Prev
        </button>
        <button onClick={() => setPlaying(p => !p)}
          style={{ padding: "9px 28px", background: playing ? "#7c3aed" : "#4f46e5", color: "#fff", border: "none", borderRadius: 8, cursor: "pointer", fontWeight: "700", fontSize: 14 }}>
          {playing ? "⏸ Pause" : step === STEPS.length - 1 ? "Done ✅" : "▶ Play"}
        </button>
        <button onClick={() => { setPlaying(false); setStep(s => Math.min(STEPS.length - 1, s + 1)); }} disabled={step === STEPS.length - 1}
          style={{ padding: "9px 18px", background: "#0f172a", color: step === STEPS.length - 1 ? "#1e293b" : "#94a3b8", border: "1px solid #1e293b", borderRadius: 8, cursor: "pointer", fontSize: 13 }}>
          Next →
        </button>
      </div>

      {/* Step dots */}
      <div style={{ display: "flex", gap: 3, justifyContent: "center", marginTop: 14, flexWrap: "wrap" }}>
        {STEPS.map((_, i) => (
          <div key={i} onClick={() => { setPlaying(false); setStep(i); }}
            style={{
              width: i === step ? 18 : 7, height: 7, borderRadius: 4,
              background: i === step ? "#6366f1" : i < step ? "#312e81" : "#0f172a",
              cursor: "pointer", transition: "all 0.3s",
              border: i === step ? "1px solid #818cf8" : "1px solid #1e293b",
            }} />
        ))}
      </div>
    </div>
  );
}
