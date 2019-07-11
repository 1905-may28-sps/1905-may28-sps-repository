import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MavenComponent } from './maven.component';

describe('MavenComponent', () => {
  let component: MavenComponent;
  let fixture: ComponentFixture<MavenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MavenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MavenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
