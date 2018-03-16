import { Filme } from './Filme.model';
export class Cliente {
    public id?: number;
    public nome?: string;
    public cpf?: string;
    public dataNascimento?: Date;
    public filme?: Filme = new Filme();
}