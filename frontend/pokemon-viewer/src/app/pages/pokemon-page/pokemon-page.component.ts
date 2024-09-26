import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgFor, NgOptimizedImage, Location } from '@angular/common'
import {MatGridListModule} from '@angular/material/grid-list';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { PokeApiService } from '../../services/poke-api.service';
import { PokemonStatComponent } from '../../components/pokemon-stat/pokemon-stat.component';
import { PokemonTypesComponent } from "../../components/pokemon-types/pokemon-types.component";
import { PokemonAbilitiesComponent } from "../../components/pokemon-abilities/pokemon-abilities.component";
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'app-pokemon-page',
  standalone: true,
  imports: [NgOptimizedImage, MatGridListModule, NgFor, MatProgressBarModule, PokemonStatComponent,
     PokemonTypesComponent, PokemonAbilitiesComponent, MatButton],
  templateUrl: './pokemon-page.component.html',
  styleUrl: './pokemon-page.component.scss'
})
export class PokemonPageComponent implements OnInit {


  id: number = 0;
  
  content: any = {};

  constructor(private route:ActivatedRoute, private service: PokeApiService, private location: Location){

  }
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.loadData(this.id);
  }

  loadData(id:number) : void {
    this.service.getPokemon(id).subscribe(data => {
      this.content = data;
      console.log(data);
    });
  }

  goBack(): void {
    this.location.back();
  }
}
