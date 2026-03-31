/**
 * @name Forbidden CI/CD Tool: Trivy
 * @description Detekuje zakázané použití Trivy v GitHub Actions workflow.
 * @kind problem
 * @problem.severity error
 * @id custom/forbidden-trivy-action
 */

import actions

from Step s
where
  // Hledáme kroky (steps), které používají akci od aquasecurity
  s.getUses().regexpMatch("(?i)aquasecurity/trivy-action.*")
select s, "KRITICKÉ VAROVÁNÍ: Detekováno zakázané použití Trivy v CI/CD workflow."