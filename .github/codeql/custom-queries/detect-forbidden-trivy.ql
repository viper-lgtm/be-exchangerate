/**
 * @name Forbidden CI/CD Tool: Trivy
 * @description Detekuje zakázané použití Trivy v YAML konfiguracích.
 * @kind problem
 * @problem.severity error
 * @id custom/forbidden-trivy-action
 */

import javascript

from StringLiteral action
where
  // Hledá text kdekoli, nezávisle na tom, zda je to v YAML uzel nebo hodnota
  action.getValue().regexpMatch(".*aquasecurity/trivy-action.*")
select action, "KRITICKÉ VAROVÁNÍ: Detekováno zakázané použití Trivy v CI/CD workflow."