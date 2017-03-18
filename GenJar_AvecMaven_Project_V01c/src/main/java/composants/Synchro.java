package composants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

// modif22 of the code
// comment on synchro yet
public class Synchro {

	Logger log = Logger.getLogger(this.getClass().getName());

	private static BufferedReader getOutput(Process p) {
		return new BufferedReader(new InputStreamReader(p.getInputStream()));
	}

	private static BufferedReader getError(Process p) {
		return new BufferedReader(new InputStreamReader(p.getErrorStream()));
	}

	

	public boolean executer(String _idaCygdrive, String _odaCygdrive) {
		boolean ok=true;	

		try {
			String commandeRsync = "rsync -av " + _idaCygdrive + " " + _odaCygdrive; 
			log.info(commandeRsync);
			String[] commande = {"cmd.exe", "/C", "D:/Softs/Cygwin/bin/bash.exe -c '" + commandeRsync + "'"};
			Process p = Runtime.getRuntime().exec(commande);
			BufferedReader output = getOutput(p);
			BufferedReader error = getError(p);
			String ligne = "";

			while ((ligne = output.readLine()) != null) {
				System.out.println(ligne);
			}

			while ((ligne = error.readLine()) != null) {
				System.out.println(ligne);
			}

			p.waitFor();
		} catch (IOException e) {
			ok=false;
			e.printStackTrace();
		} catch (InterruptedException e) {
			ok=false;
			e.printStackTrace();
		}
		return ok;

	}
	
	// exemple
	
	public static void main(String[] args) {
		boolean ok=true;
		
		Logger mainlog = Logger.getLogger("main");
		System.out.println("Début du programme");
		
		Synchro synchro = new Synchro();
		String idaCygdrive = "/cygdrive/d/users/herve.marchal/Desktop/WorkDesktop/Medde_InterfaceFiltreAgent_Project_V02a/data";
		String odaCygdrive = "/cygdrive/h/data";
		
		mainlog.info("== Debut de traitement");
		synchro.executer(idaCygdrive,odaCygdrive);
		
		if(ok==true) {
			mainlog.info("== Fin de traitement en succes - exit=0");
			System.exit(0);
		} else {
			mainlog.severe("** Fin de traitement en echec - exit=1");
			System.exit(1);
		}
	}
	
}