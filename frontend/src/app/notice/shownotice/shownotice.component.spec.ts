import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShownoticeComponent } from './shownotice.component';

describe('ShownoticeComponent', () => {
  let component: ShownoticeComponent;
  let fixture: ComponentFixture<ShownoticeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShownoticeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShownoticeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
