import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PokemonPageComponent } from './pages/pokemon-page/pokemon-page.component';

export const routes: Routes = [
    {path: '', redirectTo: '/home', pathMatch: 'full'},
    {path: 'home', component: HomeComponent},
    {path: 'pokemon/:id', component: PokemonPageComponent}
];
