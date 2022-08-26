package exercicio2;

public class Principal {
	

import exercicio2.Carro;
import exercicio2.DAO;

public class Principal {
	public Inserir{
		DAO dao = new DAO();
		
		dao.conectar();
		Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
		if(dao.inserirUsuario(usuario) == true) {
			System.out.println("Inserção com sucesso -> " + usuario.toString());
			dao.close();
		}
		
	}
	
	public atualizarUser{
		DAO dao = new DAO();
		
		dao.conectar();
		usuario.setSenha("nova senha");
		dao.atualizarUsuario(usuario);
		dao.close();
		
	}
	public mostrar usuarios{
		DAO dao = new DAO();
		
		dao.conectar();
		usuarios = dao.getUsuarios();
		System.out.println("==== Mostrar usuários === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		dao.close();
		
	}
	public excluir{
	DAO dao = new DAO();
		
		dao.conectar();
		dao.excluirUsuario(usuario.getCodigo());
		dao.close();
	}
	 public static void menu(String[]args){
	        System.out.println("\tCarros");
	        System.out.println("0. Fim");
	        System.out.println("1. Inserir");
	        System.out.println("2. Atualizar");
	        System.out.println("3. listar");
	        System.out.println("4. excluir");
	   
	    }
		
		public static void main(String[] args) {
			
			
			int opcao;
	        Scanner entrada = new Scanner(System.in);
	        
	        do{
	            menu();
	            opcao = entrada.nextInt();
	            
	            switch(opcao){
	            case 1:
	                Inserir();
	                break;
	                
	            case 2:
	            	 atualizarUser();
	                break;
	                
	            case 3:
	            	mostrar usuarios();
	                break;
	                
	            case 4:
	            	excluir();
	                break;
	            
	            default:
	                System.out.println("Opção inválida.");
	            }
	        } while(opcao != 0);
	    }
			

			
	
		
			

		}
	


