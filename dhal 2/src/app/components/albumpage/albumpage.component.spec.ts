import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumpageComponent } from './albumpage.component';

describe('AlbumpageComponent', () => {
  let component: AlbumpageComponent;
  let fixture: ComponentFixture<AlbumpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlbumpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbumpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
