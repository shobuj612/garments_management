import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SewingListComponent } from './sewing-list.component';

describe('SewingListComponent', () => {
  let component: SewingListComponent;
  let fixture: ComponentFixture<SewingListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SewingListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SewingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
