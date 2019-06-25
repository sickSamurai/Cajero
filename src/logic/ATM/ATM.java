package logic.ATM;

import database.account.AccountDAO;
import database.account.AccountDTO;
import database.card.CardDAO;
import database.card.CardDTO;

public class ATM {

	private AccountDTO cuentaDTO;
	private long dineroDisponible;
	private CardDTO tarjetaDTO;
	public CardDAO m_TarjetaDAO;
	public AccountDAO m_CuentaDAO;
	public CardDTO m_TarjetaDTO;
	public AccountDTO m_CuentaDTO;

	public ATM(){

	}
        public void bloquearTarjeta(AccountDTO cuenta){

	}

	public boolean cuentaActiva(AccountDTO cuentaDTO){
		return false;
	}
        
	public long realizarTransaccion(int monto, AccountDTO cuenta){
		return 0;
	}

	public long retirarDinero(long monto){
		return 0;
	}

	public boolean validarClave(String clave, int intentos){
		return false;
	}

	public boolean validarRetiro(AccountDTO cuentaDTO) {
		return false;
	}
}