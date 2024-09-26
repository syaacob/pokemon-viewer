import { NgFor } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-pokemon-types',
  standalone: true,
  imports: [NgFor],
  templateUrl: './pokemon-types.component.html',
  styleUrl: './pokemon-types.component.scss'
})
export class PokemonTypesComponent {

  @Input() typeData: any[] = [];

}
