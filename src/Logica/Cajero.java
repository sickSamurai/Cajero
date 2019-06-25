package logica;

import baseDeDatos.Tarjeta.TarjetaDAO;
import baseDeDatos.Cuenta.CuentaDAO;
import baseDeDatos.Cuenta.CuentaDTO;
import baseDeDatos.Tarjeta.TarjetaDTO;

public class Cajero {

	private CuentaDTO cuentaDTO;
	private long dineroDisponible;
	private TarjetaDTO tarjetaDTO;
	public TarjetaDAO m_TarjetaDAO;
	public CuentaDAO m_CuentaDAO;
	public TarjetaDTO m_TarjetaDTO;
	public CuentaDTO m_CuentaDTO;

	public Cajero(){

	}
        public void bloquearTarjeta(CuentaDTO cuenta){

	}

	public boolean cuentaActiva(CuentaDTO cuentaDTO){
		return false;
	}
        
	public long realizarTransaccion(int monto, CuentaDTO cuenta){
		return 0;
	}

	public long retirarDinero(long monto){
		return 0;
	}

	public boolean validarClave(String clave, int intentos){
		return false;
	}

	public boolean validarRetiro(CuentaDTO cuentaDTO) {
		return false;
	}
}