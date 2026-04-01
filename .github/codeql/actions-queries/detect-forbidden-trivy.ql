/**
 * @name Forbidden CI/CD Tool: Trivy
 * @description Detekuje zakázané použití Trivy v GitHub Actions workflow.
 * @kind problem
 * @problem.severity error
 * @security-severity 1.0
 * @id custom/forbidden-trivy-action
 * @tags security external/cwe/cwe-1104
 */

import actions

from UsesStep s
where
  s.getUses().regexpMatch("(?i)aquasecurity/trivy-action.*")
select s, "KRITICKÉ VAROVÁNÍ: Detekováno zakázané použití Trivy."