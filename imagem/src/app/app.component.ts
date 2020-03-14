import {  HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedFile: File= null;
  constructor(private http: HttpClient){}

  onFileSelectd(event){
    this.selectedFile= <File>event.target.files[0];
  }
  onUpload(){
    const fd= new FormData;
    fd.append('file', this.selectedFile,this.selectedFile.name)
    this.http.post("http://localhost:9000/api/file/uploadFile",fd).
    subscribe(res=>{
      console.log(res);
    })
  }
}
