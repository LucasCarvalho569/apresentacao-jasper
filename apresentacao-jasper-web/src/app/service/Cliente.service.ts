import { Injectable } from "@angular/core";
import { AbstractHttpService } from "./abstract-http.service";
import { Cliente } from "../model/Cliente.model";
import { Http } from "@angular/http";
import { Observable } from "rxjs";


@Injectable()
export class ClienteService extends AbstractHttpService<any[]> {
    constructor(http: Http) {
        super('cliente', http);
    }

    public gerarRelatorio(): Observable<Blob> {
        return this.get();
    }
}