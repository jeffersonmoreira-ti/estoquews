package br.com.storm.estoque.ws;

import br.com.storm.estoque.modelo.item.ItemDao;
import br.com.storm.estoque.modelo.item.ListaItens;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.com.storm.estoque.modelo.item.Filtro;
import br.com.storm.estoque.modelo.item.Filtros;
import br.com.storm.estoque.modelo.item.Item;

@WebService
public class EstoqueWS {

	private ItemDao itemDao = new ItemDao();

	@WebMethod(operationName = "todosOsItens")
	@WebResult(name = "item")
	@ResponseWrapper(localName="itens")
	@RequestWrapper(localName="listarTodosOsItens")
	public List<Item> getItems() {
		System.out.println("WS Itens Called");
		return itemDao.todosItens();
	}
	
	@WebMethod(operationName="itensPorTipo")
	@WebResult(name="itens")
	public ListaItens getItensPorTipo(@WebParam(name="filtros") Filtros filtros){
		System.out.println("Chamando Método para listar Itens de acordo com os Filtros");
		List<Filtro> lista = filtros.getLista();
		List<Item> itemResultado = itemDao.todosItens(lista);
		
		return new ListaItens(itemResultado);
	}

}
