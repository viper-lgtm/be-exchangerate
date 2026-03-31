/**
 * @name Forbidden CI/CD Tool: Trivy
 * @description Detekuje zakázané použití Trivy v YAML konfiguracích.
 * @kind problem
 * @problem.severity error
 * @id custom/forbidden-trivy-action
 */

import yaml

from YamlScalar scalar
where
  scalar.getValue().regexpMatch(".*aquasecurity/trivy-action.*")
select scalar, "KRITICKÉ VAROVÁNÍ: Detekováno zakázané použití Trivy v CI/CD workflow."