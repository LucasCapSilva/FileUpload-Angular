import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FileDownloadService } from 'src/app/service/file-download.service';
import { saveAs } from 'file-saver';

const MIME_TYPES = {
  pdf: 'application/pdf',
  xls: 'application/vnd.ms-excel',
  xlsx: 'application/vnd.openxmlformats-officedocument.spreadsheetxml.sheet',
  jpg: 'image/jpeg'
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedFile: File = null;
  constructor(private http: HttpClient, private service: FileDownloadService) { }

  ngOnInit() {
  }

  onFileSelectd(event) {
    this.selectedFile = <File>event.target.files[0];
  }
  onUpload() {
    const fd = new FormData;
    fd.append('file', this.selectedFile, this.selectedFile.name)
    this.http.post("http://localhost:9000/api/file/uploadFile", fd).
      subscribe(res => {
        console.log(res);
      })
  }

  download() {
    this.service.down().subscribe(data => {
      //save it on the client machine.
      saveAs(new Blob([data], { type: MIME_TYPES["jpg"] }))
    })
  }
}
