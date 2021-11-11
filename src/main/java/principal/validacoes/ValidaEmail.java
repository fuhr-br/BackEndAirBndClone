package principal.validacoes;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ValidaEmail {
	
	//interface funcionar com lambda para validar se é um email
	public static Predicate<String> isEmail = email -> {
		String validaemail = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(validaemail);
		return pattern.matcher(email).matches(); 
	};
	//interface funcional com lambda para verificar se está vazio
	public static Predicate<String> isNotEmpty = value -> value != null && value.trim().length() > 0;

}
