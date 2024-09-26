import { NgFor } from '@angular/common';
import { Component, Input } from '@angular/core';
import {MatProgressBarModule} from '@angular/material/progress-bar';

@Component({
  selector: 'app-pokemon-stat',
  standalone: true,
  imports: [MatProgressBarModule, NgFor],
  templateUrl: './pokemon-stat.component.html',
  styleUrl: './pokemon-stat.component.scss'
})
export class PokemonStatComponent {

  @Input() statData: any[] = [];

}
