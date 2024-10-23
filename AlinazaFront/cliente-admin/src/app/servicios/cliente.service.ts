import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Cliente {
  id: number;
  nombre: string;
  sharedKey: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private apiUrl = 'http://localhost:8080/clientes';

  constructor(private http: HttpClient) { }

  getClientes(): Observable<Cliente[]> {
    // List clientes
    return this.http.get<Cliente[]>(`${this.apiUrl}`);
  }

  
  buscarCliente(sharedKey: string): Observable<Cliente[]> {
    // Busca cliente -> shared key
    return this.http.get<Cliente[]>(`${this.apiUrl}/buscar?sharedKey=${sharedKey}`);
  }

  
  crearCliente(cliente: Cliente): Observable<Cliente> {
    // Creaa cliente
    return this.http.post<Cliente>(`${this.apiUrl}`, cliente);
  }
}