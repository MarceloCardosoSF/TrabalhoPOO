
import java.util.Locale;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
    	
    	
    	Locale.setDefault(Locale.US);
    	Scanner sc=new Scanner(System.in);
    	
        
        Produto produtosVar = new Produto();
        Cliente cliente = new Cliente();
        ItemPedido item = new ItemPedido();
        Pedido pedido = new Pedido();
        
        int proximo = 1;
        int addId=0;
        int numPedido=0;
        
        char continuar;
        int opcao;
        char vamos;
        
        do {
        	System.out.println("Bem-Vindo ao menu");
        	System.out.println("-----------------");
        	System.out.println("Que ação deseja realizar?");
        	System.out.println("1- Acrescentar um produto");
        	System.out.println("2- Listar os produtos");
        	System.out.println("3- Acrescentar um cliente");
        	System.out.println("4- Realizar pedido");
        	System.out.println("5- Listar os itens pedidos");
        	System.out.println("6- Cancelar um pedido");
        	opcao = sc.nextInt();
        	
        	switch(opcao){
        	case 1 :
        		sc.nextLine();
        		System.out.println("Vamos adicionar um novo produto");
        		System.out.println("Digite o nome do produto");
        		String name = sc.nextLine();
        		
        		System.out.println("Digite o valor do produto");
        		double produto = sc.nextDouble();
        		
        		System.out.println("Digite a quantidade que tem no estoque");
        		int estoque = sc.nextInt();
        		
        		Produto produto21 = new Produto(name,produto,estoque,addId);
        		produtosVar.adcionarProdutos(produto21);
        		
        		addId++;
        		
        		for(Produto prod : produto21.getProdutos()) {
        			prod.mostrarProduto();
        		}
        	
        	break;
        	case 2 :{
        		if( produtosVar.getProdutos().isEmpty()){
        			System.out.println("Você não tem produtos na lista!");
        		}else {
        			for(Produto prod : produtosVar.getProdutos()) {
            			prod.mostrarProduto();
            			System.out.println("--------------");
        				
            		}
        		}
        		
        	}break;
        	
        	
        	case 3:{
        		sc.nextLine();
        		System.out.println("Adicionar um novo cliente");
        		System.out.println("--------------------");
        		System.out.println("Digite o nome do cliente");
        		String nome = sc.nextLine();
        		
        		System.out.println("Digite o CPF do cliente");
        		String cpf = sc.nextLine();
        		
        		Cliente cli = new Cliente(nome,cpf);
        		
        		if(cliente.acharCpf(cpf)) {
        			cliente.adicionarCliente(cli);
        		}else {
        			System.out.println("CPF já cadastrado!");
        		}
        	}break;
        	
        	case 4:{
        		sc.nextLine();
        		System.out.println("Realizar pedido");
        		System.out.println("Digite o CPF do cliente");
        		String cpf = sc.nextLine();
        		
    
        		
        		if(cliente.retornaCliente(cpf) !=null){
        			System.out.println(cliente.retornaCliente(cpf).getNome());
        			
            		Pedido novoPedido = new Pedido(cliente.retornaCliente(cpf));
        			do {
        				System.out.println("Que produtos você gostaria de adicionar?");
        				for(Produto prod : produtosVar.getProdutos()) {
        					System.out.println("------------");
        					prod.mostrarProduto();
        					System.out.println("--------------");
        					
        					proximo++;
        				}
        				
        				
        			
        				System.out.println("Digite o número indicado");
        				int numeroProduto = sc.nextInt();
        				
        				System.out.println("Digite a quantidade que você gostaria");
        				
        				int quantidade = sc.nextInt();
        				
        				
        				double retornaValor = produtosVar.retornaProduto(numeroProduto).getPrecoProduto() * quantidade;
        				
        				ItemPedido novoItemPedido = new ItemPedido(novoPedido,produtosVar.retornaProduto(numeroProduto),retornaValor,quantidade,numPedido);
        				
        				if(produtosVar.error(numeroProduto, quantidade)) {
        					
        					pedido.adicionarSla(novoItemPedido);
        					for(ItemPedido it : pedido.getSla()) {
                    			it.mostrarItemPedido();
                    		}
        				}
        					
        				
        				System.out.println("Adionar novo item ? (Y/N)");
        				vamos=sc.next().charAt(0);
        			}
        				while(vamos == 'y' || vamos == 'Y');
        			
            		numPedido++;
        				
        				
        		}
        		
        	}break;
        	
        	case 5:{
        		for(ItemPedido it : pedido.getSla()) {
        			it.mostrarItemPedido();
        		}
        		}break;
        	case 6 :{
        		do {
        			System.out.println("Tela de cancelamento de pedido");
            		System.out.println("Digite o número do pedido");
            		int cancelar = sc.nextInt();
            		
            		pedido.cancelarPedido(cancelar);
            		
            		
            		System.out.println("Gostaria de efetuar novo cancelamento?? (Y/N)");
            		vamos=sc.next().charAt(0);
            		
            		
        		}while(vamos == 'y' || vamos == 'Y');
        	
        	}
        	break;
        	}
        	
        	
        	System.out.println("você gostaria de continuar? (Y/N)");
        	continuar = sc.next().charAt(0);
        	
        }
        while(continuar == 'y' || continuar =='Y');
        


        
        item.mostrarItemPedido();
            

    }
}