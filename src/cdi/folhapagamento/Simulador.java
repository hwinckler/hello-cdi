package cdi.folhapagamento;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

@Target({TYPE, FIELD, METHOD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Simulador {
	PlanoDeCargos planoDeCargos() default PlanoDeCargos.VERSAO_2005;
}
