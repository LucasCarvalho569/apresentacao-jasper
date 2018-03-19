import { Http, RequestOptions, Headers, ResponseContentType } from "@angular/http";
import { Observable } from "rxjs";
import 'rxjs/Rx';

export abstract class AbstractHttpService<T> {

    private filename;
    private DEFAULT_ERROR_MESSAGE = 'Ocorreu um erro inesperado. Por favor tente novamente.';

    private apiUrl: string = 'http://localhost:8082/';

    constructor(
        private resource: string, 
        private http: Http) {
    }

    public queryOnePath(path: string): Observable<T> {
        return this.http.get(`${this.apiUrl}${this.resource}/${path}`, this.getCustomOptions())
            .map(response => response.json())
            .catch(error => Observable.throw(error.json().message || this.DEFAULT_ERROR_MESSAGE))
    }

    public customPutAll(requestBody: T[],endPoint:string): Observable<T[]> {
        return this.http.put(`${this.apiUrl}${this.resource}${endPoint}`, requestBody, this.getCustomOptions())
            .map(response => response.json())
            .catch(error => Observable.throw(error.json().message || this.DEFAULT_ERROR_MESSAGE))
    }

    public customPut(requestBody: T,endPoint:string) : Observable<T> {
        return this.http.put(`${this.apiUrl}${this.resource}${endPoint}`,requestBody, this.getCustomOptions())
            .map(response => response.json())
            .catch(error => Observable.throw(error.json().message || this.DEFAULT_ERROR_MESSAGE))
    }
    public putAll(requestBody: T[]): Observable<T[]> {
        return this.http.put(`${this.apiUrl}${this.resource}`, requestBody, this.getCustomOptions())
            .map(response => response.json())
            .catch(error => Observable.throw(error.json().message || this.DEFAULT_ERROR_MESSAGE))
    }

    public queryAllPath(path: string): Observable<T[]> {
        return this.http.get(`${this.apiUrl}${this.resource}/${path}`, this.getCustomOptions())
            .map(response => response.json())
            .catch(error => Observable.throw(error.json().message || this.DEFAULT_ERROR_MESSAGE))
    }

    public get(): Observable<Blob> {
        return this.http.get(`${this.apiUrl}${this.resource}`, this.getOptionsForBlob())
            .map(res => {
                this.filename = res.headers.get('content-disposition').substr(20);
                return new Blob([res.blob()], { type: res.blob().type })
            })
    }

    public post(requestBody: T): Observable<T> {
        return this.http.post(`${this.apiUrl}${this.resource}`, requestBody, this.getCustomOptions())
            .map(response => response.json())
            .catch(error => Observable.throw(error.json().message || this.DEFAULT_ERROR_MESSAGE))
    }

    public postFormData(formData: FormData): Observable<any> {
        let headers = new Headers();
        headers.append('auth-token', localStorage.getItem('auth-token'));
        let opt =  new RequestOptions({headers: headers});

        return this.http.post(`${this.apiUrl}${this.resource}`, formData, opt)
            .map(response => response.json())
            .catch(error => Observable.throw(error.json().message || this.DEFAULT_ERROR_MESSAGE))
    }

    public put(requestBody: T): Observable<T> {
        return this.http.put(`${this.apiUrl}${this.resource}/${requestBody['id']}`, requestBody, this.getCustomOptions())
            .map(response => response.json())
            .catch(error => Observable.throw(error.json().message || this.DEFAULT_ERROR_MESSAGE))
    }

    public delete(requestBody: T) {
        return this.http.delete(`${this.apiUrl}${this.resource}/${requestBody['id']}`, this.getCustomOptions())
            .map(response => response)
            .catch(error => Observable.throw(error.json().message || this.DEFAULT_ERROR_MESSAGE))
    }

    private addQueryParam(property:any,value:any,queryParams:string) :any {
        if(property && value != null && value != undefined && value.toString().trim() != "") {
            if(queryParams === '') {
                queryParams += `${property}=${value}`;
            }
            else {
                queryParams += `&${property}=${value}`; 
            }
        }
        return queryParams;
    }

    private getCustomOptions(): RequestOptions {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        headers.append('auth-token', localStorage.getItem('auth-token'));
        
        return new RequestOptions({headers: headers});
    }

    public getOptionsForBlob(): RequestOptions {
        let headers = new Headers();
        headers.append('Accept', 'application/json');
        return new RequestOptions({ headers: headers, responseType: ResponseContentType.Blob });
    }
    public getFileName() {
        return this.filename;
    }
}