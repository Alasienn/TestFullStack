import { Component, OnInit } from '@angular/core';
import { ClienteService, Cliente } from '../servicios/cliente.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[] = [];
  clienteForm: FormGroup;
  sharedKeyBusqueda: string = '';

  constructor(private clienteService: ClienteService, private fb: FormBuilder) {
    this.clienteForm = this.fb.group({
      nombre: ['', Validators.required],
      sharedKey: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  ngOnInit(): void {
    this.obtenerClientes();
  }

  // lista
  obtenerClientes(): void {
    this.clienteService.getClientes().subscribe((data: Cliente[]) => {
      this.clientes = data;
    });
  }

  // buscar 
  buscarCliente(): void {
    if (this.sharedKeyBusqueda) {
      this.clienteService.buscarCliente(this.sharedKeyBusqueda).subscribe((data: Cliente[]) => {
        this.clientes = data;
      });
    } else {
      this.obtenerClientes();
    }
  }

  // creaa cliente
  crearCliente(): void {
    if (this.clienteForm.valid) {
      const nuevoCliente: Cliente = this.clienteForm.value;
      console.log(nuevoCliente)
      this.clienteService.crearCliente(nuevoCliente).subscribe(() => {
        this.obtenerClientes();
        this.clienteForm.reset();
      });
    }
  }
}
