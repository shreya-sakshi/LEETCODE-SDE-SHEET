using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;

namespace DocumentService.WebAPI.Models
{
    public class Document : IValidatableObject
    {
        public string Title { get; set; }
        public int Size { get; set; }
        public string Format { get; set; }

        public IEnumerable<ValidationResult> Validate(ValidationContext validationContext)
        {
            var errors = new List<ValidationResult>();

            // 1. Title validation
            if (string.IsNullOrWhiteSpace(Title) ||
                Title.Length < 5 ||
                Title.Length > 35 ||
                !Title.Split(' ').All(w => !string.IsNullOrEmpty(w) && char.IsUpper(w[0])))
            {
                errors.Add(new ValidationResult(
                    "Title is invalid: Title must contain a minimum of 5 characters and a maximum of 35, and each word should start with an uppercase letter",
                    new[] { nameof(Title) }));
            }

            // 2. Size validation
            if (Size <= 0 || Size >= 500)
            {
                errors.Add(new ValidationResult(
                    "Size is invalid: Size must be greater than 0 MB and less than 500 MB",
                    new[] { nameof(Size) }));
            }

            // 3. Format validation
            var allowedFormats = new[] { "txt", "pdf", "docx" };

            if (string.IsNullOrWhiteSpace(Format) ||
                Format != Format.ToLower() ||
                !allowedFormats.Contains(Format))
            {
                errors.Add(new ValidationResult(
                    "Format is invalid: Format must be lowercase and equal one of the following: 'txt', 'pdf', 'docx'",
                    new[] { nameof(Format) }));
            }

            return errors;
        }
    }
}


