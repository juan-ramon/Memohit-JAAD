package JAAD;

public class Token {
	
	private char valor;
	
	public Token(char valor)
	{
		this.valor=valor;
	}
	
	public char getValor() {
		return valor;
	}

	public void setValor(char valor) {
		this.valor = valor;
	}
	
	public void reproduce(){
		System.out.println(valor);
	}
	
	public boolean equals(Token t){
		return this.valor==t.valor;
	}

}
