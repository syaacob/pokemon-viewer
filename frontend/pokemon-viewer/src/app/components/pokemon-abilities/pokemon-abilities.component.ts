import { NgFor } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-pokemon-abilities',
  standalone: true,
  imports: [NgFor],
  templateUrl: './pokemon-abilities.component.html',
  styleUrl: './pokemon-abilities.component.scss'
})
export class PokemonAbilitiesComponent {

  @Input() abilityData: any[] = [];

}
