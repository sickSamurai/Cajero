package BaseDeDatos.Cuenta;

import BaseDeDatos.Tarjeta.TarjetaDTO;

public interface ICuentaDAO {

    public void actualizarSaldo(CuentaDTO saldoCuenta);

    public CuentaDTO obtenerCuenta(TarjetaDTO tarjeta);

}
