package com.algaworks.course.fjoo.math.bigdecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/*
 * java.lang.math.BigDecimal (imutável).
 * BigDecimal é um tipo apropriado para se trabalhar com valores decimais,
 * que permite se trabalhar com segurança em relação à precisão.
 * 
 * Fornece métodos para as quatro operações básicas entre outros.
 * add()
 * subtract()
 * divide()
 * multiply()
 * 
 * compareTo() -> é utilizado para se comparar valores.
 * -1 -> Valor menor que o comparado.
 * 0 -> Valor igual ao comparado.
 * 1 -> Valor maior que o comparado.
 * 
 * O construtor de BigDecimal recebe uma String, mas tem sobrecarga para outros tipos,
 * porém é recomendado informar uma String, devido poder representar literalmente o valor que se deseja,
 * e não ter os mesmos problemas de arredontamentos e casas decimais que se teria com tipos comuns.
 * 
 */

public class BigDecimalExample {

	public void calculate() {
		System.out.println("BigDecimalExample -> calculate:");
		
		BigDecimal valorEmDolar = new BigDecimal("10.00");
		BigDecimal cotacaoEmDolar = new BigDecimal("2.43");
		BigDecimal valorEmReais = valorEmDolar.multiply(cotacaoEmDolar);

		BigDecimal pagamento = new BigDecimal("25.00");

		BigDecimal troco = pagamento.subtract(valorEmReais);

		if (troco.compareTo(new BigDecimal("0.70")) == 0) {
			System.out.println("Tudo certo, isso é matemática! " + "Valor do troco: " + troco);
		} else {
			System.out.println("Impossível de acontecer. Será? " + "Valor do troco: " + troco);
		}
		
		System.out.println("========================================");
	}

	public void testFormat(BigDecimal value) {
		System.out.println("BigDecimalExample -> testFormat:");
		
		/*
		 * javax.text.DecimalFormat -> Classe para formatação geral de números decimais.
		 * Separador padrão . (ponto) é utilizado para separar as casas decimals da parte inteira.
		 */
		
		DecimalFormat decimalFormat = new DecimalFormat("##0.00");
		
		System.out.println("Valor formatado: " + decimalFormat.format(value));
		
		/*
		 * javax.text.NumberFormat -> Classe abstrata base para todos os formatos de número.
		 * Podemos obter uma instância com localidade, utilizando ela e o métoido getInstance(),
		 * passando um Locale como argumento.
		 */
		
		DecimalFormat decimalFormatWithLocale = (DecimalFormat) NumberFormat.getInstance(new Locale("pt", "BR"));
		decimalFormat.applyPattern("##0.00");
		
		System.out.println("Valor formatado (Localidade pt-BR): " + decimalFormatWithLocale.format(value));
		
		/*
		 * Para exibirmos o símbolo de uma moeda local, podemos utilizar getCurrencyInstance()
		 * da classe NumberFormat, novamente passando um Locale.
		 * 
		 * Obs.: Não é necessário informar o padrão de formatação,
		 * a API já sabe a quantidade de casas decimais da moeda local.
		 */
		
		NumberFormat numberFormatWithLocaleCurrency = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		
		System.out.println("Valor formatado (Localidade pt-BR e R$): " + numberFormatWithLocaleCurrency.format(value));
		
		System.out.println("========================================");
	}
	
	/*
	 * NumberFormat também pode ser utilizada para fazer o parse (interpretação) de um valor String
	 * para converter em um valor que possa ser utilizado para realizar operações matemáticas.
	 */
	
	public void testParse(String value) {
		System.out.println("BigDecimalExample -> testFormat:");
		
		NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt", "BR"));
		
		try {
			/*
			 * Valor deverá ser informado com vírgula, devido ao locale,
			 * se não obtemos uma java.lang.ClassCastException,
			 * pois o Java vai entender como um Long,
			 * tentando fazer um cast de um Long (Classe wrapper)
			 * diretamente para um Double (Classe wrapper).
			 */
			
			Double valorConvertido = (Double) numberFormat.parse(value);
			
			valorConvertido += 5.0;
			
			System.out.println("Novo valor: " + valorConvertido);
			
		} catch (ParseException | ClassCastException e) {
			System.err.println("Não foi possível realizar o parse da String informada.\n" + e.getMessage());
			System.exit(1);
		} finally {
			System.out.println("========================================");
		}
	}
}