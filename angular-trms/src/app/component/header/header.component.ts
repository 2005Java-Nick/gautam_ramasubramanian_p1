import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Input()
  headerTitle : string;

  imgLink : string = "http://newdesignfile.com/postpic/2014/09/reimbursement-icon_282289.png";

  constructor() { }

  ngOnInit(): void {
  }

}
