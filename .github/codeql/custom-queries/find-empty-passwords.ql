/**
 * @name Empty password assignment
 * @description Finds variables with 'password' in their name that are initialized with an empty string.
 * @kind problem
 * @problem.severity warning
 * @id java/example/empty-password-assignment
 * @tags security
 */

import java

from Variable v, StringLiteral s
where
  v.getName().toLowerCase().matches("%password%") and
  v.getInitializer() = s and
  s.getValue() = ""
select v, "This variable '" + v.getName() + "' is assigned an empty string."