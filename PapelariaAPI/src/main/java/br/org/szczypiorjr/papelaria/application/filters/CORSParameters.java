package br.org.szczypiorjr.papelaria.application.filters;

public enum CORSParameters {

	ACCESS_CONTROL_ALLOW_ORIGIN("Access-Control-Allow-Origin", "*"),
	ACCESS_CONTROL_ALLOW_METHODS_1("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS"),
	ACCESS_CONTROL_ALLOW_METHODS_2("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT"),

	ACCESS_CONTROL_ALLOW_HEADERS_1("Access-Control-Allow-Headers", "Authorization, Content-Type"),
	ACCESS_CONTROL_ALLOW_HEADERS_2("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia"),
								   
	
	
	ACCESS_CONTROL_ALLOW_CREDENTIALS("Access-Control-Allow-Credentials", "true"),
	ACCESS_CONTROL_EXPOSE_HEADERS("Access-Control-Expose-Headers", "Authorization"),
	ACCESS_CONTROL_MAX_AGE("Access-Control-Max-Age", "3600");
	
	private String parametro;
    private String valor;

	
    public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
    CORSParameters(String parametro,String valor) {
        this.parametro = parametro;
        this.valor = valor;
    }

   
}
