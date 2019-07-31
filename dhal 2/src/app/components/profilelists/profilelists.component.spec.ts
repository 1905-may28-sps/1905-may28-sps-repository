import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilelistsComponent } from './profilelists.component';

describe('ProfilelistsComponent', () => {
  let component: ProfilelistsComponent;
  let fixture: ComponentFixture<ProfilelistsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilelistsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilelistsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
