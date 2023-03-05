package com.example.demo.common;

import java.lang.annotation.Target;

import javax.persistence.ParameterMode;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Specifies a parameter of a named stored procedure query.  All
 * parameters of a named stored procedure query must be specified.
 *
 * @see NamedStoredProcedureQuery
 * @see ParameterMode 
 *
 * @since Java Persistence 2.1
 */
@Target({}) 
@Retention(RUNTIME)
public @interface StoredProcedureParameter { 

    /** 
     *  The name of the parameter as defined by the stored procedure in the database.
     *  If a name is not specified, it is assumed that the stored procedure uses
     *  positional parameters.
     */
    String name() default "";

    /**
     *  Specifies whether the parameter is an IN, INOUT, OUT, or REF_CURSOR parameter.
     *  REF_CURSOR parameters are used by some databases to return result sets from
     *  a stored procedure.
     */
    ParameterMode mode() default ParameterMode.IN;

    /** JDBC type of the paramter. */
    @SuppressWarnings("rawtypes")
	Class type();

}
