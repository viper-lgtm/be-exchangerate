/**
 * @name Missing HTTP timeout configuration
 * @description Detect OkHttpClient instances without explicit timeout settings.
 * @kind problem
 * @problem.severity warning
 * @id java/exchange-rate/missing-http-timeout
 */

import java
import semmle.code.java.dataflow.DataFlow

from ConstructorCall cc
where
  // Hledáme volání konstruktoru OkHttpClient
  cc.getConstructedType().hasQualifiedName("okhttp3", "OkHttpClient") and
  // A zároveň neexistuje následné volání metody pro timeout
  not exists(MethodCall mc |
    mc.getQualifier().(MethodCall).getQualifier*() = cc and
    mc.getMethod().getName() in ["connectTimeout", "readTimeout", "writeTimeout"]
  )
select cc, "Tento OkHttpClient pravděpodobně postrádá explicitní nastavení timeoutu."