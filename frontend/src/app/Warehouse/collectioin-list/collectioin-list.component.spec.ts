import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CollectioinListComponent } from './collectioin-list.component';

describe('CollectioinListComponent', () => {
  let component: CollectioinListComponent;
  let fixture: ComponentFixture<CollectioinListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CollectioinListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CollectioinListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
