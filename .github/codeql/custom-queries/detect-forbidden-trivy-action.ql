/**
 * @name Forbidden CI/CD Tool: Trivy
 * @description Detekuje zakázané použití Trivy v YAML konfiguracích.
 * @kind problem
 * @problem.severity error
 * @id custom/forbidden-trivy-action
 */

import yaml // Změna importu pro kompatibilitu s 'actions'

from YamlNode node
where
  node.toString().regexpMatch(".*aquasecurity/trivy-action.*")
select node, "KRITICKÉ VAROVÁNÍ: Detekováno zakázané použití Trivy v CI/CD workflow."