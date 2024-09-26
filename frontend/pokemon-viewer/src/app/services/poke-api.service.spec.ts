import { TestBed } from '@angular/core/testing';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';

import { PokeApiService } from './poke-api.service';
import { provideHttpClient } from '@angular/common/http';

describe('PokeApiService', () => {
  let service: PokeApiService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokeApiService, provideHttpClient(), provideHttpClientTesting()]
    });
    service = TestBed.inject(PokeApiService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  })

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should call list api successfully', () => {

    const mockData = {
      
      results: [
        { id: 1, name: 'poke 1' },
        { id: 2, name: 'poke2' },
        { id: 3, name: 'poke2' }
      ],
      count: 2000
    };

    service.listPokemons(0, 20).subscribe((data) => {
      expect(data.count).toBe(2000)
      expect(data.results.length).toBe(3);
    });

    const req = httpMock.expectOne(service.url +"?offset=0&limit=20");

    expect(req.request.method).toBe('GET');
    req.flush(mockData);
  });

  it('should call get pokemon api successfully', () => {
    const mockData = {
      id: "100",
      name: 'poke1',
      avatar: 'http://abc',
      defaultImage : 'http://xyz'
    }

    service.getPokemon(100).subscribe((data)=> {
      expect(data.id).toBe("100");
      expect(data.name).toBe("poke1");
    });
    const req = httpMock.expectOne(service.url +"/100");
    expect(req.request.method).toBe('GET');
    req.flush(mockData);

  })
});



