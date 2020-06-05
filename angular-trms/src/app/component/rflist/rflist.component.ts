import { Component, OnInit } from '@angular/core';
import { GetrfService } from '../../service/getrf.service';

@Component({
  selector: 'app-rflist',
  templateUrl: './rflist.component.html',
  styleUrls: ['./rflist.component.css']
})
export class RflistComponent implements OnInit {

  constructor(private getrfService : GetrfService) { }

  ngOnInit(): void {
    this.getrfService.getRFs().subscribe((message) => {
      console.log(message);
    });
  }

}
