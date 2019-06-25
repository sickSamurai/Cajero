package baseDeDatos.Cuenta;

import baseDeDatos.Tarjeta.TarjetaDTO;

public interface ICuentaDAO {

	public void actualizarSaldo(CuentaDTO saldoCuenta);

	public CuentaDTO obtenerCuenta(TarjetaDTO tarjeta);
}
