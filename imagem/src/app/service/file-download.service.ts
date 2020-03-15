import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FileDownloadService {

  constructor(private http: HttpClient) { }

  down() {
    const REQUEST_URI = '/server/api/file/downloadFile/gato.jpeg';
    return this.http.get(REQUEST_URI, {
      responseType: 'blob'
    })
  }
}
