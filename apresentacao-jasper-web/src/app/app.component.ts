import { Component } from '@angular/core';
import { ClienteService } from './service/Cliente.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  mensagem: any;

  constructor(private clienteService: ClienteService) { }

  public gerarRelatorio() {
    let arquivo;
    this.clienteService.gerarRelatorio().subscribe(res => {
      arquivo = res;
      let fileUrl = URL.createObjectURL(res);
      var link = document.createElement("a");
      link.download = this.clienteService.getFileName();
      link.href = fileUrl;
      link.click();
    });
  }

  public gerarRelatorioComParametro() {
    let arquivo;
    this.clienteService.gerarRelatorioComParametro(this.mensagem).subscribe(res => {
      arquivo = res;
      let fileUrl = URL.createObjectURL(res);
      var link = document.createElement("a");
      link.download = this.clienteService.getFileName();
      link.href = fileUrl;
      link.click();
    });
  }

}
