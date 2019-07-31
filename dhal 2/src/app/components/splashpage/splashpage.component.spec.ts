import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SplashpageComponent } from './splashpage.component';

describe('SplashpageComponent', () => {
  let component: SplashpageComponent;
  let fixture: ComponentFixture<SplashpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SplashpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SplashpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
