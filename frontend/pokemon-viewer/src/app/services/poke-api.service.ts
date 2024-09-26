import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class PokeApiService {
  url = environment.backendUrl;

  constructor(private http: HttpClient) { }

  listPokemons(offset: number, limit: number): Observable<ListResponse>{
    let options = {
      params: new HttpParams().set("offset", offset).set("limit", limit)  
    }
    return this.http.get<ListResponse>(`${this.url}`, options);
  }
  getPokemon(id: number) : Observable<PokemonDetail> {
      return this.http.get<PokemonDetail>(`${this.url}/` + id);
  }
}

export interface ListResponse {
  count: number,
  next: string,
  previous: string
  results: ResultResponse[]
}

export interface ResultResponse {
  name: string,
  avatar: string,
  baseExperience: number
}

export interface PokemonDetail {
  id: string,
  name: string,
  avatar: string,
  defaultImage: string
}