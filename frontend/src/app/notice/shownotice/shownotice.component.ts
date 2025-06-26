import { Component, OnInit } from '@angular/core';
import { NoticeService } from '../../Services/noticeServie/notice.service';
import { FileModel } from '../../Model/file.model';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-shownotice',
  imports:[NgIf,NgFor],
  standalone: true,
  templateUrl: './shownotice.component.html',
  styleUrls: ['./shownotice.component.css']
})
export class ShownoticeComponent implements OnInit {
  fileList: FileModel[] = [];
  showTable: boolean = true;

  constructor(
    private fileService: NoticeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.showTable = true; // Ensure visible on init
    this.loadFiles();

    // Reset showTable when user navigates back to this component
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => {
      this.showTable = true;
      this.loadFiles(); // Optionally reload files too
    });
  }

  closeTable(): void {
    this.showTable = false;
  }

  loadFiles(): void {
    this.fileService.getFiles().subscribe(files => {
      this.fileList = files;
    });
  }
}
