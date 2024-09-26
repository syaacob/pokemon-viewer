import { NgFor, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { ListResponse, PokeApiService } from '../../services/poke-api.service';
import { ActivatedRoute, ParamMap, RouterLink } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatButtonModule, MatCardModule, NgFor, RouterLink, NgIf,MatPaginator],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {

  dataSet: any[] = [];
  offset: number = 10;
  limit = 10;
  totalItems = 0;

  constructor(private route:ActivatedRoute, private pokeService: PokeApiService){

  }
  ngOnInit(): void {
    this.route.queryParamMap.subscribe(params => {
      console.log(params.get("offset"));
      this.offset = Number(params.get("offset"))
    });
    this.loadData();
    
  }

  loadData() : void {
    this.pokeService.listPokemons(this.offset, this.limit).subscribe(
      data => {console.log(data);
        this.dataSet = data.results;
        this.totalItems = data.count;
      }
    );
  }

  refreshPage() : void {
    this.loadData();
  }

  onPageChange(event: any): void {
    this.offset = event.pageIndex * 10;  // Material paginator is zero-indexed
    this.limit = event.pageSize;
    this.loadData(); // Fetch data for the new page
  }

}
