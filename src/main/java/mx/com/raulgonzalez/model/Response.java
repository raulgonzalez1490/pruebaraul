package mx.com.raulgonzalez.model;

import com.google.gson.Gson;

public class Response<O> {

	private int codigoRespuesta;
	private String mensaje;
	private O respuesta;

	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public O getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(O respuesta) {
		this.respuesta = respuesta;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
