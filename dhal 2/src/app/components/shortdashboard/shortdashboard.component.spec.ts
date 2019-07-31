import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShortdashboardComponent } from './shortdashboard.component';

describe('ShortdashboardComponent', () => {
  let component: ShortdashboardComponent;
  let fixture: ComponentFixture<ShortdashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShortdashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShortdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
