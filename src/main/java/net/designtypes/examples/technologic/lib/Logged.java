package net.designtypes.examples.technologic.lib;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

@InterceptorBinding
@Retention(RUNTIME)
@Target({ METHOD, TYPE, ANNOTATION_TYPE, PACKAGE })
public @interface Logged {

}
