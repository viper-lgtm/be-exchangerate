/**
 * @name Missing HTTP timeout configuration
 * @description detect OkHttpClient instances without explicit timeout settings.
 * @kind problem
 * @problem.severity warning
 * @id java/exchange-rate/missing-http-timeout
 */

import java
import semmle.code.java.dataflow.DataFlow

from ConstructorCall cc
where
  cc.getConstructedType().hasQualifiedName("okhttp3", "OkHttpClient") and
  not exists(MethodCall mc |
    mc.getQualifier().(MethodCall).getQualifier*() = cc and
    mc.getMethod().getName() in ["connectTimeout", "readTimeout", "writeTimeout"]
  )
select cc, "This OkHttpClient might be missing explicit timeout configurations."